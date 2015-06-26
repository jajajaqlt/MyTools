package pac1;

import org.tartarus.snowball.SnowballStemmer;

public class SnowballStemmerMain {
	public static void main(String[] args) throws Exception {
		Class stemClass = Class.forName("org.tartarus.snowball.ext."
				+ "english" + "Stemmer");
		SnowballStemmer stemmer = (SnowballStemmer) stemClass.newInstance();
		stemmer.setCurrent("sports");
		stemmer.stem();
		String your_stemmed_word = stemmer.getCurrent();
		System.out.println(your_stemmed_word);
	}
}
