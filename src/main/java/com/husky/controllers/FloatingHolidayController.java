package com.husky.controllers;
import com.husky.entities.FloatingHoliday;
import com.husky.repositories.FloatingHolidayRepository;
import com.husky.utils.CsvHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Vector;

@RestController
public class FloatingHolidayController {

    @Autowired
    private FloatingHolidayRepository floatingHolidayRepository;

    @PostMapping("/registerHolidaysFromCsv")
    public HashMap<String, String > handleFileUpload(@RequestParam("file") MultipartFile file){
       HashMap<String, String> httpStatus;
       httpStatus = new HashMap<String, String>();
       try{
           CsvHandler csvHandler = new CsvHandler(file);
           Vector<FloatingHoliday> resultVector = csvHandler.getCsvDataAsFloatingHolidays();
           for (FloatingHoliday floatingHoliday :resultVector) {
               if (floatingHoliday!= null){
                   floatingHolidayRepository.save(floatingHoliday);
               }
           }
           httpStatus.put("200: ","OK");
       } catch (Exception exception) {
           httpStatus.put("Reason:",exception.getMessage());
           httpStatus.put("400: ", "FAIL");
       }
       return httpStatus;
    }
}
