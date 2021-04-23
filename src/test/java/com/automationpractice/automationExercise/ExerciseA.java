package com.automationpractice.automationExercise;
import java.util.Map;

import org.testng.annotations.Test;

import com.automationpractice.base.CsvDataProviders;
import com.automationpractice.base.TestUtilities;

public class ExerciseA extends TestUtilities{

	@Test(invocationCount = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void exercise(Map<String, String> testData) {
		
		
	}
}