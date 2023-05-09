package tasks.model;

import org.apache.log4j.Logger;

import java.util.Objects;

public class Validator {
    private static final Logger log = Logger.getLogger(Validator.class.getName());

    public Validator() {}

    public Boolean checkData(String startDate, String endDate, String hourStartDate, String hourEndDate) {
        boolean hasError = false;
        if(startDate==null) {
            log.error("Please select a start date");
            hasError = true;
        }
        if(endDate==null) {
            log.error("Please select an end date");
            hasError = true;
        }
        if(Objects.equals(hourEndDate, "")) {
            log.error("Please select a time for the end date");
            hasError = true;
        }
        if(Objects.equals(hourEndDate, "")) {
            log.error("Please select a time for the start date");
            hasError = true;
        }
        return hasError;
    }
}
