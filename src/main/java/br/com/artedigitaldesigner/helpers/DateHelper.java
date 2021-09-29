package br.com.artedigitaldesigner.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	public static Date toDate(String date) {

		int ano = Integer.parseInt(date.substring(0, 4));
		int mes = Integer.parseInt(date.substring(5, 7));
		int dia = Integer.parseInt(date.substring(8, 10));

		Calendar cal = new GregorianCalendar(ano, mes - 1, dia);
		return cal.getTime();
	}

	public static Date toDatePtBR(String date) {

		int ano = Integer.parseInt(date.substring(6, 10));
		int mes = Integer.parseInt(date.substring(3, 5));
		int dia = Integer.parseInt(date.substring(0, 2));

		Calendar cal = new GregorianCalendar(ano, mes - 1, dia);
		return cal.getTime();
	}

	public static String toString(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(data);
	}

	public static String toStringPtBR(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

	public static String toStringLine(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		return sdf.format(data);
	}
}
