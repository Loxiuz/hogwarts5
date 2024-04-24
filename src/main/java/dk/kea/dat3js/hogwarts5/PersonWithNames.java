package dk.kea.dat3js.hogwarts5;

public interface PersonWithNames {

//    String firstName = "";
//    String lastName  = "";
//    String middleName = "";

    String getMiddleName();

    String getFirstName();

    String getLastName();

    void setMiddleName(String middleName);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    /************************
     * Capitalization Feature
     ************************/

    default String capitalize(String name){
        if(name != null && !name.isEmpty()){
            String firstPart = name.substring(0, 1).toUpperCase();
            String lastPart = name.substring(1).toLowerCase();
            return firstPart + lastPart;
        } else {
            return null;
        }
    }

//    default String getFullName(){
//        return firstName + " " + (middleName !=null ? middleName + " " : "") + lastName;
//    }

    default void setFullName(String fullName){
        if(fullName != null && !fullName.isEmpty()){
            int firstSpace = fullName.indexOf(' ');
            int lastSpace = fullName.lastIndexOf(' ');

            setFirstName(fullName.substring(0, firstSpace));
            if (firstSpace != lastSpace) {
                setMiddleName(fullName.substring(firstSpace + 1, lastSpace));
            } else {
                setMiddleName(null);
            }
            setLastName(fullName.substring(lastSpace + 1));
        } else {
            setFirstName(null);
            setMiddleName(null);
            setLastName(null);
        }
    }
}
