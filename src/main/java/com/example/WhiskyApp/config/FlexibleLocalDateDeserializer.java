package com.example.WhiskyApp.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

public class FlexibleLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private static final List<DateTimeFormatter> formatters = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd.MM.yyyy"),
            DateTimeFormatter.ofPattern("dd.MM.yy"),
            DateTimeFormatter.ofPattern("d.M.yyyy"),
            DateTimeFormatter.ofPattern("d.M.yy"),
            DateTimeFormatter.ofPattern("d.MM.yyyy"),
            DateTimeFormatter.ofPattern("d.MM.yy"),
            DateTimeFormatter.ofPattern("dd.M.yyyy"),
            DateTimeFormatter.ofPattern("dd.M.yy"),
            DateTimeFormatter.ofPattern("MM.yyyy"),
            DateTimeFormatter.ofPattern("MM.yy"),
            DateTimeFormatter.ofPattern("M.yyyy"),
            DateTimeFormatter.ofPattern("M.yy"),
            DateTimeFormatter.ofPattern("dd.MM"),
            DateTimeFormatter.ofPattern("d.M"),
            DateTimeFormatter.ofPattern("d.MM"),
            DateTimeFormatter.ofPattern("dd.M")
    );

    private static final Set<DateTimeFormatter> formatsWithoutYear = Set.of(
            DateTimeFormatter.ofPattern("dd.MM"),
            DateTimeFormatter.ofPattern("d.M"),
            DateTimeFormatter.ofPattern("d.MM"),
            DateTimeFormatter.ofPattern("dd.M")
    );

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateStr = p.getText().trim();
        dateStr = dateStr.replaceAll("\\.$", "");

        for (DateTimeFormatter formatter : formatters) {
            try {
                LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
                if (formatsWithoutYear.contains(formatter)) {
                    parsedDate = parsedDate.withYear(LocalDate.now().getYear());
                }
                return parsedDate;
            } catch (DateTimeParseException e) {
                // Ignore and try next formatter
            }
        }

        throw new RuntimeException("Unparseable date: " + dateStr);
    }
}