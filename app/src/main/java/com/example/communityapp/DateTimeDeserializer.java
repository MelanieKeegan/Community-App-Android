package com.example.communityapp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import java.lang.reflect.Type;

public class DateTimeDeserializer implements JsonDeserializer<DateTime> {
    @Override
    public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return ISODateTimeFormat.dateTimeParser().parseDateTime(json.getAsString());
    }
}
