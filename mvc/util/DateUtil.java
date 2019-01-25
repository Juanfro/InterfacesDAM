package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Helper para manejar fechas
 * 
 * @author Juan Antonio Rodriguez
 *
 */
public class DateUtil {
	/**
	 * El patrón de fecha que se usa para conversión
	 */
	private static final String DATE_PATTERN = "dd.MM.yyyy";

	/**
	 * Formateador de fecha
	 */
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	/**
	 * Devuelve la fecha dada como un String bien formateado. <br>
	 * El {@link DateUtil#DATE_PATTERN} definido arriba es utilizado
	 * 
	 * @param date La fecha que se devuelve como String
	 * @return
	 */
	public static String format(LocalDate date) {
		String sol = DATE_FORMATTER.format(date);
		if (date == null) {
			sol = null;
		}

		return sol;
	}

	public static LocalDate parse(String dateString) {
		LocalDate sol;
		try {
			sol = DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			sol = null;
		}

		return sol;
	}

	/**
	 * Comprueba si es una fecha válida
	 * 
	 * @param dateString
	 * @return True si el String es una fecha válida
	 */
	public static boolean validDate(String dateString) {
		// Intenta parsear el String recibido
		return DateUtil.parse(dateString) != null;
	}

}
