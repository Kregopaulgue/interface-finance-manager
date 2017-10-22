package ExpenceEntries;

import HelperTypes.ExpenceEntryType;
import HelperTypes.FoodType;

import java.util.Calendar;

/**
 * Created by Master on 18.10.2017.
 */
public class FoodExpenceEntry extends OtherExpenceEntry {

    private String textFoodType = new String("");
    private FoodType foodType;

    public FoodExpenceEntry(Double moneySpent, Integer importance, String comment,
                            FoodType foodType, String textFoodType) {
        super(moneySpent, importance, comment);
        this.entryType = ExpenceEntryType.FOOD;
        this.foodType = foodType;

        if(this.foodType == FoodType.OTHER) {
            this.foodType = FoodType.OTHER;
            this.textFoodType = textFoodType;
        }

        chechForImportance(foodType, importance);
    }

    public FoodExpenceEntry(Double moneySpent, Integer importance, String comment, Calendar time, Calendar Calendar,
                            ExpenceEntryType entryType, String textFoodType, FoodType foodType) {
        super(moneySpent, importance, comment, time, Calendar, entryType);

        this.foodType = foodType;
        this.entryType = ExpenceEntryType.FOOD;
        if(this.foodType == FoodType.OTHER) {
            this.foodType = FoodType.OTHER;
            this.textFoodType = textFoodType;
        }

        chechForImportance(foodType, importance);
    }

    public void chechForImportance(FoodType foodType, Integer importance) {

        if(this.foodType == FoodType.UNIMPORTANT_FOOD
                || this.foodType == FoodType.SWEETS) {

            if(importance > 4) {
                System.out.println("Importance is too high for this product");
                System.out.println("By default it is set to 4");
                this.importance = 4;
            }
            else {
                this.importance = importance;
            }

        }
    }

    public String getTextFoodType() {
        return textFoodType;
    }

    public void setTextFoodType(String textFoodType) {
        this.textFoodType = textFoodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
}
