package TechDetectives.HobbyFinder.models;

import java.util.ArrayList;

public class HobbyData {
    public static ArrayList<Hobby> findByColumnAndValue(String column, String value, Iterable<Hobby> allHobbies) {

        ArrayList<Hobby> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Hobby>) allHobbies;
        }

        if (column.equals("all")) {
            results = findByValue(value, allHobbies);
            return results;
        }
        for (Hobby hobby : allHobbies) {

            String aValue = getFieldValue(hobby, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(hobby);
            }
        }

        return results;
    }

    public static String getFieldValue(Hobby hobby, String fieldName) {
        String theValue;
        if (fieldName.equals("name")) {
            theValue = hobby.getName();
        } else {
            theValue = hobby.getCategory().toString();
        }
        return theValue;
    }

    public static ArrayList<Hobby> findByValue(String value, Iterable<Hobby> allHobbies) {
        ArrayList<Hobby> results = new ArrayList<>();

        for (Hobby hobby : allHobbies) {
            if (hobby.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(hobby);
            } else if (hobby.getCategory().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(hobby);
            }
        }
        return results;
    }
}
