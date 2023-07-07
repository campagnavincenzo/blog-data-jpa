package it.campagnavincenzo.blog.dto;

/**
 * get postTilte + body summary
 */
public interface PostSummary {

	String getPostTitle();

	String getBody();

	default String getPostSummary() {
		return getPostTitle().concat(System.lineSeparator()).concat(getBody().substring(0, 10)).concat("......");
	}

}