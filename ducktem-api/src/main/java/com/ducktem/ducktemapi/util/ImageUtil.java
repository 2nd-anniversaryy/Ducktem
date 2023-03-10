package com.ducktem.ducktemapi.util;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {
	private static final String localUrl =
		System.getProperty("user.dir") + File.separator + "ducktem-app" + File.separator + "public";

	public static String productImgSave(MultipartFile file) {
		String productImgPath = localUrl + "/productimgs/";
		return fileSave(file, productImgPath);
	}

	public static String profileImgSave(MultipartFile file) {
		String profileImgPath = localUrl + "/profileimgs/";
		return fileSave(file, profileImgPath);

	}

	private static String fileSave(MultipartFile file, String path) {
		UUID uuid = UUID.randomUUID();
		if (file == null) {
			return null;
		}

		String imgName = uuid + "_" + file.getOriginalFilename();
		File imgFile = new File(path, imgName);
		try {
			file.transferTo(imgFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String fileUrl = Arrays.stream(path.split("/"))
			.filter(url -> url.contains("productimgs"))
			.findAny()
			.orElse("profileimgs");
		System.out.println(File.separator + fileUrl + File.separator+ imgName);
		return File.separator + fileUrl + File.separator+ imgName;
	}
}
