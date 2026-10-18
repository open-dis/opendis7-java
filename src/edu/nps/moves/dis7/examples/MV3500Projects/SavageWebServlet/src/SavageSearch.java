//
//  SavageSearch.java
//
//
//  Created by Don McGregor on 11/16/06.
//  Copyright 2006 __MyCompanyName__. All rights reserved.
//
public class SavageSearch
{
    /**
     * Search a database for a term.
     *
     * @param database The database to be searched for the term
     * @param term The string to search for in the database
     * @return a String[] with results from search
     */
    public String[] search(String database, String term)
    {
        String result[] = new String[2];

        result[0] = "https://savage.nps.edu/Savage/AircraftFixedWing/AV8B-Harrier-UnitedStates/AV8bHarrier.x3d";
        result[1] = "https://savage.nps.edu/Savage/AircraftFixedWing/AV8B-Harrier-UnitedStates/TranslatedAv8bHarrier.x3d";
        return result;
    }

    /**
     * Returns hits from an "expansive" search that also searches chapter and section
     * headings for the search term
     *
     * @param database the database to be searched
     * @param term the term to search for
     * @return a String[] with results from search
     */
    public String[] expansiveSearch(String database, String term)
    {
        return search(database, term);
    }

}
