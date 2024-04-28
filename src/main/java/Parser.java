import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName() {
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        Collections.sort(sortedByName, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        return sortedByName;
    }

    public List<Country> sortByPopulation() {
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        Collections.sort(sortedByPopulation, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return Integer.compare(c2.getPopulation(),c1.getPopulation());
            }
        });
        return sortedByPopulation;
    }

    public List<Country> sortByArea() {
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        Collections.sort(sortedByArea, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return Double.compare(c2.getArea(),c1.getArea());
            }
        });
        return sortedByArea;
    }

    public static void setUp() throws IOException {
        //Parse the HTML file using Jsoup
        File input = new File("src\\Resources\\country-list.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        // Extract data from the HTML
        Elements names = doc.select(".country-name");
        Elements capitals = doc.select(".country-capital");
        Elements populations = doc.select(".country-population");
        Elements areas = doc.select(".country-area");
        // Iterate through each country div to extract country data
        for (int i = 0; i < names.size(); i++) {
            Country country = new Country(names.get(i).text(),capitals.get(i).text(),Integer.parseInt(populations.get(i).text()),Double.parseDouble(areas.get(i).text()));
            countries.add(country);
        }
    }

    public static void main(String[] args) throws IOException {
        setUp();
        //you can test your code here before you run the unit tests ;)
        //Bawshe :3
    }
}
