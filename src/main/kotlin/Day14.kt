class Day14: Day(14){
    override fun part1(input: List<String>, test:Boolean): String {
        var polymer = input[0]
        val iterations = 10
        val rules = mutableMapOf<String, String>()
        //Pair, Depth, (Char, Counts)
        val paircounts = mutableMapOf<String, MutableMap<Int, MutableMap<Char, Long>>>()
        val counts = mutableMapOf<Char, Long>()
        for (i in 2 until input.size){
            counts.putIfAbsent(input[i].last(), 0)
            val rule = "" + input[i][0] +input[i][1]
            rules[rule ] = "${input[i][0]}${input[i].last()}" //${input[i][1]}"
            paircounts[rule] = mutableMapOf()
        }
        for (i in 0 until iterations){
            for(rule in rules){
                //Init
                val paircounts_for_rule: MutableMap<Int, MutableMap<Char, Long>> = paircounts[rule.key]!!
                paircounts_for_rule[i] = copyCounts(counts)

                if (i != 0){
                    for (count in paircounts[rule.value]!![i-1]!!){
                        paircounts_for_rule[i]!![count.key] = paircounts_for_rule[i]!![count.key]!! + count.value
                    }
                    for (count in paircounts[rule.value[1].toString() + rule.key[1]]!![i-1]!!){
                        paircounts_for_rule[i]!![count.key] = paircounts_for_rule[i]!![count.key]!! + count.value
                    }
                }else{
                    paircounts_for_rule[i]!![rule.key.first()] = 1
                    paircounts_for_rule[i]!![rule.key.last()] = 1
                }

            }
        }


        /*
        for (i in 0 until iterations){
            var newPolymer = StringBuilder()
            for (j in 0.. polymer.length-2){
                newPolymer.append(rules[polymer.substring(j,j+2)])
            }
            polymer = newPolymer.append(polymer.last()).toString()
            //println(polymer)
        }*/

        polymer.forEach { c: Char -> counts[c] = counts[c]!! + 1 }

        if (false) {
            for (rule in rules) {
                println(rule)
            }
        }
        if (test){
            for (count in counts){
                println(count)
            }
        }
        return (counts.values.maxOrNull()!! - counts.values.minOrNull()!!).toString()
        //1419894 ns
    }

    private fun copyCounts(counts: MutableMap<Char, Long>): MutableMap<Char, Long> {
        val tmp_counts = mutableMapOf<Char, Long>()
        for (count in counts){
            tmp_counts[count.key] = count.value
        }
        return tmp_counts
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        var polymer = input[0]
        val iterations = 40
        val rules = mutableMapOf<String, String>()
        val counts = mutableMapOf<Char, Long>()
        for (i in 2 until input.size){
            counts.putIfAbsent(input[i].last(), 0)
            rules["" + input[i][0] +input[i][1] ] = "${input[i][0]}${input[i].last()}" //${input[i][1]}"
        }
        for (i in 0 until iterations){
            var newPolymer = StringBuilder()
            for (j in 0.. polymer.length-2){
                newPolymer.append(rules[polymer.substring(j,j+2)])
            }
            polymer = newPolymer.append(polymer.last()).toString()
            //println(polymer)
        }

        polymer.forEach { c: Char -> counts[c] = counts[c]!! + 1 }

        if (false) {
            for (rule in rules) {
                println(rule)
            }
        }
        if (test){
            for (count in counts){
                println(count)
            }
        }
        return (counts.values.maxOrNull()!! - counts.values.minOrNull()!!).toString()
    }

}
