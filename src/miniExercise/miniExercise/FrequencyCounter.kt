package com.example.crm.app.miniExercise

class FrequencyCounter {
    /**
     * Counts frequency of each character in a string.
     *
     * Rules:
     * - Case insensitive (A == a)
     * - DO NOT allow spaces (will throw exception)
     *
     * Example:
     * Input: "aabccc"
     * Output: {a=2, b=1, c=3}
     */
    fun countFrequency(text: String): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()

        val lowerText = text.lowercase()
        val list = lowerText.toList()

        for(i in 0..list.count()-1){
            println(list.get(i))

            if(result.containsKey(list.get(i))){
               val count = result[list.get(i)]!!+1
                result.put(list.get(i), count)

            }else{
                result.put(list.get(i), 1)
            }
        }
        println(result)
        return result
    }
}