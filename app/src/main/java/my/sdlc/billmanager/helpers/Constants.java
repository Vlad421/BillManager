package my.sdlc.billmanager.helpers;

import java.util.Map;

public class Constants {



    //Categories
    public static class Categories {
        private static final Map<String,String> defaultSpentCategories = Map.ofEntries(

                Map.entry("GROCERY", "Grocery"),
                Map.entry("COSMETICS", "Cosmetics"),
                Map.entry("TRANSPORTATION", "Transportation"),
                Map.entry("EATING_OUT", "Eating_out"),
                Map.entry("ENTERTAINMENT", "Entertainment"),
                Map.entry("MOBILE_INTERNET", "Mobile_internet"),
                Map.entry("MEDICATION", "Medication"),
                Map.entry("CLOTHES_SHOES", "Clothes_shoes"),
                Map.entry("SMOKING", "Smoking"),
                Map.entry("TOYS_CRAFT", "Toys_craft"),
                Map.entry("APPLIANCES_TECHS", "Appliances_techs"),
                Map.entry("HOME_WARE", "Home_ware"),
                Map.entry("LAUNDRY", "Laundry"),
                Map.entry("RENT", "Rent"),
                Map.entry("UTILITIES", "Utilities"),
                Map.entry("PETS", "Pets"),
                Map.entry("HOLIDAYS", "Holidays"),
                Map.entry("TOOLS", "Tools")



        );




              //                  "GROCERY : grocery", "COSMETICS", "TRANSPORTATION", "EATING_OUT", "ENTERTAINMENT", "MOBILE_INTERNET", "MEDICATION", "CLOTHES_SHOES",
                //                        "SMOKING", "TOYS_CRAFT", "APPLIANCES_TECHS", "HOME_WARE", "LAUNDRY", "RENT", "UTILITIES", "PETS", "HOLIDAYS, TOOLS"


        private static final String[] defaultIncomeCategories = {"JOB", "FB_MARKET","GIG"};

        public static Map<String, String> getDefaultSpentCategories() {
            return defaultSpentCategories;
        }
        public static void setCategories(){

        }

    }
    public enum Month {
        January, February, March, April, May, June, July, August, September, October, November, December;
    }

}
