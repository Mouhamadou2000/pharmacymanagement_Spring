package fr.sup.galilee.pharmacy.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Dates {

	 public Date from(LocalDateTime from) {
	        return Date.from(from.atZone(ZoneId.systemDefault()).toInstant());
	    }
}
