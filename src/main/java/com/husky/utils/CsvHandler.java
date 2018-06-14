package com.husky.utils;

import com.husky.entities.FloatingHoliday;
import com.husky.entities.Gender;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class CsvHandler {
    public final static String DATE_FORMAT = "yyyy/MM/dd";
    private MultipartFile file;
    private int numberOfColumns =5;
    private final String[] csvHeaders = {"date","hours","userGender","userParent","description"};

    public CsvHandler(MultipartFile file){
        this.file = file;
    }

    public Vector<FloatingHoliday> getCsvDataAsFloatingHolidays()throws Exception{
        String [] columns = separateFileInStrings(file);
        Vector<FloatingHoliday> resultVector;
        if (dataIsEmpty(columns)){
            throw new Exception("Empty csv file");
        }
        else {
            if (headerIsCorrect(columns)){
                resultVector = getDataInHolidaysFromRows(separateDataInRows(columns));
                if (resultVector.size()==0){
                    throw new Exception("Empty csv file data");
                }
            }
            else {
                throw new Exception("Invalid CSV header");
            }
            return resultVector;
        }
    }


    public String[] separateFileInStrings(MultipartFile file){
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String completeData = new String(bytes);
        String[] columns = completeData.split("\r\n");
        return columns;
    }

    public boolean headerIsCorrect(String[] columns){
        String[] header = columns[0].split(",");
        Boolean status = true;
        if (header.length == numberOfColumns){
            for (int i = 0; i < csvHeaders.length; i++) {
                if (! csvHeaders[i].equals(header[i])){
                    status = false;
                    break;
                }
            }
        }
        else{
            status = false;
        }
        return status;
    }

    public Vector<String> separateDataInRows(String[] dataInStrings){
        int headerIndex;
        Vector<String> dataInRows = new Vector<>();
        for (headerIndex =0; headerIndex < dataInStrings.length ; headerIndex++){
            String [] aux = dataInStrings[headerIndex].split(",");
            if (aux.length==5){
                dataInRows.addAll(Arrays.asList(aux));
            }
        }
        return dataInRows;
    }

    public Vector<FloatingHoliday> getDataInHolidaysFromRows(Vector<String> dataInRows){
        Vector<FloatingHoliday> resultVector = new Vector<>();
        Vector<String> dataRow =  new Vector<>();
        for (int i = 1; i<dataInRows.size()/ numberOfColumns; i++){
            dataRow.clear();
            for (int j = i* numberOfColumns; j<((i* numberOfColumns)+ numberOfColumns) ; j++){
                if (dataInRows.elementAt(j) != null || !dataInRows.elementAt(j).isEmpty() || dataInRows.elementAt(j).trim().length()>0){
                    dataRow.addElement(dataInRows.elementAt(j));
                }
                else{
                    dataRow.addElement("");
                }

            }
            FloatingHoliday floatingHoliday = convertToHolyDay(dataRow);
            resultVector.addElement(floatingHoliday);
        }
        return resultVector;
    }


    public FloatingHoliday convertToHolyDay(List<String> attributes){
        FloatingHoliday floatingHoliday = new FloatingHoliday();
        if (rowHasMissingData(attributes)){
            floatingHoliday = null;
        }
        else {
            try {
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                floatingHoliday.setDate(validateDateFormat(attributes.get(0)));
                floatingHoliday.setHours(Integer.parseInt(attributes.get(1).trim()));
                if (attributes.get(2).equals("MALE") || attributes.get(2).equals("FEMALE")){
                    floatingHoliday.setUserGender(Gender.valueOf(attributes.get(2)));
                }
                else {
                    floatingHoliday.setUserGender(null);
                }
                floatingHoliday.setHasChildren(attributes.get(3));
                floatingHoliday.setDescription(attributes.get(4));
            }catch (Exception exception){
                throw exception;
            }
        }
        return floatingHoliday;
    }

    public Date validateDateFormat(String date){
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Date formattedDate = new Date();
        try {
            if (!date.isEmpty()){
                formattedDate = new Date(df.parse(date).getTime());
            }
            else{
                formattedDate = null;
            }
        }
        catch (ParseException e) {
        }
        return formattedDate;
    }

    public boolean dataIsEmpty(String [] data){
        boolean isEmpty = false;
        int numberOfElements =0;
        for (String row:data) {
            numberOfElements = numberOfElements + row.length();
        }
        if (numberOfElements<=numberOfColumns){
            isEmpty = true;
        }
        return isEmpty;
    }

    public boolean rowHasMissingData(List<String> rowOfData){
        boolean hasMissingData = false;
        for (String element: rowOfData) {
            if (element.isEmpty() || element.trim().length()==0){
                hasMissingData = true;
                break;
            }
        }
        return hasMissingData;
    }


}
