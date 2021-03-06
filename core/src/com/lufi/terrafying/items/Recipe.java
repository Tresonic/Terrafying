package com.lufi.terrafying.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Recipe {
	public static int TYPE_NORMAL = 	0b1;
	public static int TYPE_CRAFTING = 	0b10;
	public static int TYPE_OVEN = 		0b100;
	
	
	private int id;
	
	private ArrayList<ItemStack> ingredients;
	private ItemStack result;
	private int type;
	
	private static HashMap<Integer, Recipe> recipeMap = new HashMap<Integer, Recipe>();
	
	public Recipe(int nId, int nType, ArrayList<ItemStack> nIngredients, ItemStack nResult) {
		ingredients = nIngredients;
		result = nResult;
		id = nId;
		type = nType;
	}
	
	public ArrayList<ItemStack> getIngredients() {
		return ingredients;
	}
	
	public ItemStack getResult() {
		return result;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	
	public static void registerRecipes() {
		int c = 0;
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodplanks"), 4))), new ItemStack(Item.getItemByName("craftingtable"), 1));
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("stone"), 10))), new ItemStack(Item.getItemByName("oven"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwood"), 1))), new ItemStack(Item.getItemByName("oakwoodplanks"), 4));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodplanks"), 10))), new ItemStack(Item.getItemByName("chest"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("stone"), 1))), new ItemStack(Item.getItemByName("cobble"), 4));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("sand"), 3))), new ItemStack(Item.getItemByName("window"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("sand"), 3))), new ItemStack(Item.getItemByName("glass"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("dirt"), 1), new ItemStack(Item.getItemByName("grassplant"), 1))), new ItemStack(Item.getItemByName("grass"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("whitewool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("bluewool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("yellowwool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("greenwool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("orangewool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("violetwool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("oakwoodleaves"), 1))), new ItemStack(Item.getItemByName("redwool"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("clay"), 4))), new ItemStack(Item.getItemByName("bricks"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("orangeclay"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("blueclay"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("yellowclay"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("greenclay"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("pinkclay"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("redclay"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("gravel"), 1), new ItemStack(Item.getItemByName("sand"), 1))), new ItemStack(Item.getItemByName("clay"), 1));
		
		//Items Stone
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("stone"), 2), new ItemStack(Item.getItemByName("oakwoodplanks"), 2))), new ItemStack(Item.getItemByName("stonesword"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("stone"), 2), new ItemStack(Item.getItemByName("oakwoodplanks"), 2))), new ItemStack(Item.getItemByName("stonehoe"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("stone"), 3), new ItemStack(Item.getItemByName("oakwoodplanks"), 2))), new ItemStack(Item.getItemByName("stonepickaxe"), 1));
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("stone"), 3), new ItemStack(Item.getItemByName("oakwoodplanks"), 2))), new ItemStack(Item.getItemByName("stoneaxe"), 1));
		//Items Iron	
		registerRecipe(c++, TYPE_CRAFTING | TYPE_OVEN, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("iron"), 2), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 2))), new ItemStack(Item.getItemByName("ironsword"), 1));
		registerRecipe(c++, TYPE_CRAFTING | TYPE_OVEN, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("iron"), 2), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 2))), new ItemStack(Item.getItemByName("ironhoe"), 1));
		registerRecipe(c++, TYPE_CRAFTING | TYPE_OVEN, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("iron"), 3), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 3))), new ItemStack(Item.getItemByName("ironpickaxe"), 1));
		registerRecipe(c++, TYPE_CRAFTING | TYPE_OVEN, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("iron"), 3), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 3))), new ItemStack(Item.getItemByName("ironaxe"), 1));
		//Items Diamond
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("diamond"), 2), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 2))), new ItemStack(Item.getItemByName("diamondsword"), 1));
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("diamond"), 2), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 2))), new ItemStack(Item.getItemByName("diamondhoe"), 1));
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("diamond"), 3), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 3))), new ItemStack(Item.getItemByName("diamondpickaxe"), 1));
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("diamond"), 3), new ItemStack(Item.getItemByName("oakwoodplanks"), 2), new ItemStack(Item.getItemByName("coal"), 3))), new ItemStack(Item.getItemByName("diamondaxe"), 1));
		//other Items
		registerRecipe(c++, TYPE_NORMAL, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("wool"), 1), new ItemStack(Item.getItemByName("oakwoodplanks"), 2))), new ItemStack(Item.getItemByName("brush"), 1));
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("iron"), 20), new ItemStack(Item.getItemByName("coal"), 50), new ItemStack(Item.getItemByName("uranium"), 5))), new ItemStack(Item.getItemByName("jetpack"), 1));
		registerRecipe(c++, TYPE_CRAFTING, new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Item.getItemByName("iron"), 10), new ItemStack(Item.getItemByName("copper"), 5), new ItemStack(Item.getItemByName("gold"), 5))), new ItemStack(Item.getItemByName("jetpack"), 1));
	}
	
	public static void registerRecipe(int nId, int nType, ArrayList<ItemStack> nIngredients, ItemStack nResult) {
		recipeMap.put(nId, new Recipe(nId, nType, nIngredients, nResult));
	}
	
	public static Recipe getRecipeByName(String name) {
		for(Recipe r : recipeMap.values()) {
			if(name.equals(r.result.getName())) {
				return r;
			}
		}
		return null;
	}
	
	public static Recipe getRecipe(Item item) {
		for(Recipe r : recipeMap.values()) {
			if(item.getId() == r.result.getId()) {
				return r;
			}
		}
		return null;
	}
	
	public static int getRecipeCraftableCount(Inventory inv, Recipe recipe) {
		int minCount = ItemStack.STACK_MAX;
		for(ItemStack stack : recipe.ingredients) {
			int itemCount = inv.getItemCount(stack.item);
			if(itemCount >= stack.count) {
				minCount = Math.min(minCount, itemCount / stack.count);
			}
			else {
				minCount = 0;
			}
		}
		return minCount;
	}
	
	public static ArrayList<ItemStack> getCraftableItemStacks(Inventory inv, int rType) {
		ArrayList<ItemStack> craftableStacks = new ArrayList<ItemStack>();
		for(Recipe r : recipeMap.values()) {
			if((r.type & rType) == r.type) {
				int craftableCount = getRecipeCraftableCount(inv, r);
				if(craftableCount > 0) {
					craftableStacks.add(new ItemStack(Item.getItemById(r.getResult().getId()), craftableCount));
				}	
			}
		}
		return craftableStacks;
	}
	
	public static void doCraft(Inventory inv, Item result) {
		Recipe recipe = getRecipe(result);
		if(getRecipeCraftableCount(inv, recipe) > 0) {
			for(ItemStack stack : recipe.ingredients) {
				inv.removeItem(stack);
			}
			inv.addItem(recipe.result.clone());
		}		
	}
}
