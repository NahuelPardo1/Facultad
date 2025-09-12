package ar.edu.unlp.oo1.ejercicio1;


public class WallPost {
    private String text = "Undefined post";
    private int likes;
    private boolean featured = false;

	String getText() {
		return text;
	};

	void setText(String text) {
		this.text = text;
	};

	int getLikes() {
		return likes;
	};


	void like() {
		likes++;
	};

	void dislike() {
	    if(likes>0){
	        likes--;
	    }
	};

	boolean isFeatured() {
		return featured;
	};

	void toggleFeatured() {
		this.featured = !this.featured;
	};

	@Override
	public String toString() {
		return "WallPost {" +
			"text: " + getText() +
			", likes: '" + getLikes() + "'" +
			", featured: '" + isFeatured() + "'" +
			"}";
	}

}