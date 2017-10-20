package ExpenceEntries;

import HelperTypes.ExpenceEntryType;
import HelperTypes.FoodType;

import java.util.Date;

/**
 * Created by Master on 18.10.2017.
 */
public class FoodExpenceEntry extends OtherExpenceEntry {

    private String textFoodType = new String("");
    private FoodType foodType;

    public FoodExpenceEntry(Double moneySpent, Integer importance, String comment,
                            FoodType foodType, String textFoodType) {
        super(moneySpent, importance, comment);
        this.foodType = foodType;

        if(this.foodType == FoodType.OTHER) {
            this.textFoodType = textFoodType;
        }

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

    public FoodExpenceEntry(Double moneySpent, Integer importance, String comment, Date time, Date date,
                            ExpenceEntryType entryType, String textFoodType, FoodType foodType) {
        super(moneySpent, importance, comment, time, date, entryType);

        this.foodType = foodType;

        if(this.foodType == FoodType.OTHER) {
            this.textFoodType = textFoodType;
        }

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



}
