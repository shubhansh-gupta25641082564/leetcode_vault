// Last updated: 18/09/2025, 23:29:53
import java.util.*;

public class FoodRatings {

    private static class FoodEntry {
        final String name;
        final int rating;
        FoodEntry(String name, int rating) { this.name = name; this.rating = rating; }
    }

    private final Map<String, String> foodToCuisine = new HashMap<>();
    private final Map<String, Integer> foodToRating = new HashMap<>();
    private final Map<String, TreeSet<FoodEntry>> cuisineMap = new HashMap<>();
    private final Comparator<FoodEntry> cmp = (a, b) -> {
        int r = Integer.compare(b.rating, a.rating);
        if (r != 0) return r;
        return a.name.compareTo(b.name);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];
            foodToCuisine.put(f, c);
            foodToRating.put(f, r);
            cuisineMap.computeIfAbsent(c, k -> new TreeSet<>(cmp)).add(new FoodEntry(f, r));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int old = foodToRating.get(food);
        TreeSet<FoodEntry> set = cuisineMap.get(cuisine);
        set.remove(new FoodEntry(food, old));
        foodToRating.put(food, newRating);
        set.add(new FoodEntry(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}
