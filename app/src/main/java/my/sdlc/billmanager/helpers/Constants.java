package my.sdlc.billmanager.helpers;

import androidx.annotation.NonNull;

import java.util.Map;

public class Constants {



    //Categories
    public static class Categories {
        private static final Map<String,String> defaultSpentCategories = Map.ofEntries(

                Map.entry("GROCERY", "Grocery"),
                Map.entry("COSMETICS", "Cosmetics"),
                Map.entry("TRANSPORTATION", "Transportation"),
                Map.entry("EATING_OUT", "Eating out"),
                Map.entry("ENTERTAINMENT", "Entertainment"),
                Map.entry("MOBILE_INTERNET", "Mobile/internet"),
                Map.entry("MEDICATION", "Medication"),
                Map.entry("CLOTHES_SHOES", "Clothes/shoes"),
                Map.entry("SMOKING", "Smoking"),
                Map.entry("TOYS_CRAFT", "Toys/craft"),
                Map.entry("APPLIANCES_TECHS", "Appliances/techs"),
                Map.entry("HOME_WARE", "Home/ware"),
                Map.entry("LAUNDRY", "Laundry"),
                Map.entry("RENT", "Rent"),
                Map.entry("UTILITIES", "Utilities"),
                Map.entry("PETS", "Pets"),
                Map.entry("HOLIDAYS", "Holidays"),
                Map.entry("TOOLS", "Tools")
        );


        private static final Map<String,String> defaultIncomeCategories = Map.ofEntries(
                Map.entry("JOB", "Job"),
                Map.entry("FB_MARKET", "FB Market"),
                Map.entry("GIG", "Gig")
        );



        public static Map<String, String> getDefaultSpentCategories() {
            return defaultSpentCategories;
        }

        public static Map<String, String> getDefaultIncomeCategories() {
            return defaultIncomeCategories;
        }

        public static void setCategories(){

        }

    }
    public enum Month {
        January, February, March, April, May, June, July, August, September, October, November, December;
    }

    public enum Type{
        INCOME,SPENT,NONE;

        @NonNull
        @Override
        public String toString() {
            return super.toString();
        }
    }
}
