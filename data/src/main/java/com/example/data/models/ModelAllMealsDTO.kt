package com.example.data.models

import android.os.Parcelable
import com.example.domain.models.MealsItem
import com.example.domain.models.ModelAllMeals
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelAllMealsDTO(
	val meals: List<MealsItemDTO?>? = null
) : Parcelable{
	fun toDomain(): ModelAllMeals{
		return ModelAllMeals(
			meals = meals?.map { it?.toDomain() } ?: emptyList()
		)
	}
}

@Parcelize
data class MealsItemDTO(
	val strImageSource: String? = null,
	val strIngredient10: String? = null,
	val strIngredient12: String? = null,
	val strIngredient11: String? = null,
	val strIngredient14: String? = null,
	val strCategory: String? = null,
	val strIngredient13: String? = null,
	val strIngredient16: String? = null,
	val strIngredient15: String? = null,
	val strMealAlternate: String? = null,
	val strIngredient18: String? = null,
	val strIngredient17: String? = null,
	val strArea: String? = null,
	val strCreativeCommonsConfirmed: String? = null,
	val strIngredient19: String? = null,
	val strTags: String? = null,
	val idMeal: String? = null,
	val strInstructions: String? = null,
	val strIngredient1: String? = null,
	val strIngredient3: String? = null,
	val strIngredient2: String? = null,
	val strIngredient20: String? = null,
	val strIngredient5: String? = null,
	val strIngredient4: String? = null,
	val strIngredient7: String? = null,
	val strIngredient6: String? = null,
	val strIngredient9: String? = null,
	val strIngredient8: String? = null,
	val strMealThumb: String? = null,
	val strMeasure20: String? = null,
	val strYoutube: String? = null,
	val strMeal: String? = null,
	val strMeasure12: String? = null,
	val strMeasure13: String? = null,
	val strMeasure10: String? = null,
	val strMeasure11: String? = null,
	val dateModified: String? = null,
	val strSource: String? = null,
	val strMeasure9: String? = null,
	val strMeasure7: String? = null,
	val strMeasure8: String? = null,
	val strMeasure5: String? = null,
	val strMeasure6: String? = null,
	val strMeasure3: String? = null,
	val strMeasure4: String? = null,
	val strMeasure1: String? = null,
	val strMeasure18: String? = null,
	val strMeasure2: String? = null,
	val strMeasure19: String? = null,
	val strMeasure16: String? = null,
	val strMeasure17: String? = null,
	val strMeasure14: String? = null,
	val strMeasure15: String? = null
) : Parcelable{
	fun toDomain(): MealsItem {
		return MealsItem(
			strImageSource = strImageSource,
			strIngredient10 = strIngredient10,
			strIngredient12 = strIngredient12,
			strIngredient11 = strIngredient11,
			strIngredient14 = strIngredient14,
			strCategory = strCategory,
			strIngredient13 = strIngredient13,
			strIngredient16 = strIngredient16,
			strIngredient15 = strIngredient15,
			strMealAlternate = strMealAlternate,
			strIngredient18 = strIngredient18,
			strIngredient17 = strIngredient17,
			strArea = strArea,
			strCreativeCommonsConfirmed = strCreativeCommonsConfirmed,
			strIngredient19 = strIngredient19,
			strTags = strTags,
			idMeal = idMeal,
			strInstructions = strInstructions,
			strIngredient1 = strIngredient1,
			strIngredient3 = strIngredient3,
			strIngredient2 = strIngredient2,
			strIngredient20 = strIngredient20,
			strIngredient5 = strIngredient5,
			strIngredient4 = strIngredient4,
			strIngredient7 = strIngredient7,
			strIngredient6 = strIngredient6,
			strIngredient9 = strIngredient9,
			strIngredient8 = strIngredient8,
			strMealThumb = strMealThumb,
			strMeasure20 = strMeasure20,
			strYoutube = strYoutube,
			strMeal = strMeal,
			strMeasure12 = strMeasure12,
			strMeasure13 = strMeasure13,
			strMeasure10 = strMeasure10,
			strMeasure11 = strMeasure11,
			dateModified = dateModified,
			strSource = strSource,
			strMeasure9 = strMeasure9,
			strMeasure7 = strMeasure7,
			strMeasure8 = strMeasure8,
			strMeasure5 = strMeasure5,
			strMeasure6 = strMeasure6,
			strMeasure3 = strMeasure3,
			strMeasure4 = strMeasure4,
			strMeasure1 = strMeasure1,
			strMeasure18 = strMeasure18,
			strMeasure2 = strMeasure2,
			strMeasure19 = strMeasure19,
			strMeasure16 = strMeasure16,
			strMeasure17 = strMeasure17,
			strMeasure14 = strMeasure14,
			strMeasure15 = strMeasure15
		)
	}
}
