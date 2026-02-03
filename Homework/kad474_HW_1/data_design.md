**Questions**

1. What data structure did you use to store the lines read from the input file? <br>
    I created a class called LineStorage and it stores a List<String> for easy reference

2. What data structure did you use to store the circularly shifted lines (or their indexes)? <br>
    I also stored the kwic table is a LineStorage object, so that I only had to make it once

3. What data structure did you use to store the sorted lines (or their indexes)? <br>
    Since KWICProcessor and IndexProcessor were the only functions that required their output to be in alphabetical order,
    I made sure that I only had to create those tables once. For index since not only did I need to keep track of the different keywords, but also how many sentences contained that word, instead of using LineStorage, I help that information in a TreeMap (Map<String, Integer>)