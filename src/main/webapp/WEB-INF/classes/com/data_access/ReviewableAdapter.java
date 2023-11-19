package com.data_access;

import com.entity.room.*;
import com.entity.building.Building;
import com.entity.Reviewable;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ReviewableAdapter implements JsonDeserializer<Reviewable> {

    @Override
    public Reviewable deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement typeElement = jsonObject.get("type");

        if (typeElement != null) {
            String type = typeElement.getAsString();
            switch (type) {
                case "building":
                    return context.deserialize(json, Building.class);
                case "room":
                    return context.deserialize(json, Room.class);
                case "bathroom":
                    return context.deserialize(json, Bathroom.class);
                case "lecture":
                    return context.deserialize(json, Lecture.class);
                case "tutorial":
                    return context.deserialize(json, Tutorial.class);

                // Add other cases for different Reviewable types
                default:
                    throw new JsonParseException("Unsupported Reviewable type: " + type);
            }
        } else {
            throw new JsonParseException("Type field missing in JSON for Reviewable");
        }
    }
}