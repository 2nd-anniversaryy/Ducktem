package com.ducktem.ducktemapi.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {
	private static final String localUrl = System.getProperty("user.dir") + "/ducktem-app/public";

	public static String save(MultipartFile file) {
		String productImgPath = localUrl + "/productimgs" + File.separator;

		UUID uuid = UUID.randomUUID();
		System.out.println(file.getOriginalFilename());
		if (file.getOriginalFilename() == null) {
			return null;
		}

		String productImgName = uuid + "_" + file.getOriginalFilename();
		File productImgFile = new File(productImgPath, productImgName);
		try {
			file.transferTo(productImgFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/productimgs/" + productImgName;
	}
}
