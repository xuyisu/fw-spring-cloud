package com.yisu.security.properties;

import lombok.Data;

/**
 * @author xuyisu
 *
 */
@Data
public class ImageCodeProperties{

	private int length = 4;
	private int expireIn = 60;
	private int width = 67;
	private int height = 23;


}
