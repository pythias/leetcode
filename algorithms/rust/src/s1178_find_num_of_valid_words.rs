impl Solution {
    pub fn find_num_of_valid_words(words: Vec<String>, puzzles: Vec<String>) -> Vec<i32> {
        let mut found = vec![0; puzzles.len()];

        let word_binaries = binaries(&words);
        let puzzle_binaries = binaries(&puzzles);
        let puzzle_firsts = first(&puzzles);

        for i in 0..puzzles.len() {
            let pb = puzzle_binaries[i];
            let pf = puzzle_firsts[i];
            for j in 0..words.len() {
                let wb = word_binaries[j];
                if (wb & pb) == wb && (wb & pf) == pf {
                    found[i] += 1;
                }
            }
        }

        return found;
    }
}

fn first(v: &Vec<String>) -> Vec<u32> {
    v.iter().map(|s| 2u32.pow((s.clone().as_bytes()[0] - 97) as u32)).collect::<Vec<_>>()
}

fn binaries(v: &Vec<String>) -> Vec<u32> {
    v.iter().map(|s| binary(s)).collect::<Vec<_>>()
}

fn binary(s: &String) -> u32 {
    let mut v: u32 = 0;
    for c in s.clone().as_bytes() {
        v |= 2u32.pow((c - 97) as u32);
    }
    v
}

pub struct Solution {}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_1178() {
        let mut words = Vec::new();
        words.push(String::from("aaaa"));
        words.push(String::from("asas"));
        words.push(String::from("able"));
        words.push(String::from("ability"));
        words.push(String::from("actt"));
        words.push(String::from("actor"));
        words.push(String::from("access"));

        let mut puzzles = Vec::new();
        puzzles.push(String::from("aboveyz"));
        puzzles.push(String::from("abrodyz"));
        puzzles.push(String::from("abslute"));
        puzzles.push(String::from("absoryz"));
        puzzles.push(String::from("actresz"));
        puzzles.push(String::from("gaswxyz"));

        assert_eq!(Solution::find_num_of_valid_words(words, puzzles), vec![1, 1, 3, 2, 4, 0]);

        words = Vec::new();
        words.push(String::from("apple"));
        words.push(String::from("pleas"));
        words.push(String::from("please"));

        puzzles = Vec::new();
        puzzles.push(String::from("aelwxyz"));
        puzzles.push(String::from("aelpxyz"));
        puzzles.push(String::from("aelpsxy"));
        puzzles.push(String::from("saelpxy"));
        puzzles.push(String::from("xaelpsy"));

        assert_eq!(Solution::find_num_of_valid_words(words, puzzles), vec![0, 1, 3, 2, 0]);
    }
}