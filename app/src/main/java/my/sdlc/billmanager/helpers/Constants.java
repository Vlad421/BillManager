package my.sdlc.billmanager.helpers;

public class Constants {



    //Categories
    public static class Categories {
        private static String[] categories = {"GROCERY", "COSMETICS", "TRANSPORTATION", "EATING_OUT", "ENTERTAINMENT", "MOBILE_INTERNET", "MEDICATION", "CLOTHES_SHOES",
        "SMOKING", "TOYS_CRAFT", "APPLIANCES_TECHS", "HOMEWARE", "LAUNDRY", "RENT", "UTILITIES", "PETS", "HOLIDAYS, TOOLS"};

        public static String[] getCategories() {
            return categories;
        }
        public static void setCategories(){

        }

    }


}
