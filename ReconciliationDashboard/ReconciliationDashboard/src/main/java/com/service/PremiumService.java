package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.TreeSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.model.PremiumDetail;

@Configuration
public class PremiumService {

	private static String uploadfile = "C://temp//uploaded.txt";

	// CREATE A NEW FILE

	public boolean addPremiumDetails(MultipartFile file) {
		try {
			File temp = new File(uploadfile);
			if (temp.createNewFile())
				;
			if (temp.length() != 0) {
				Files.write(Paths.get(uploadfile), System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
			}
			Files.write(Paths.get(uploadfile), file.getBytes(), StandardOpenOption.APPEND);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// EXTRACT DETAILS FROM THE UPLOADED FILE

	public TreeSet<PremiumDetail> extractPremiumDetails() {

		FileReader fr;
		Comparator<PremiumDetail> compareById = (PremiumDetail o1, PremiumDetail o2) -> o1.getMemberId()
				.compareTo(o2.getMemberId());
		TreeSet<PremiumDetail> set = new TreeSet<>(compareById);
		try {
			fr = new FileReader(uploadfile);
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
			while ((line = br.readLine()) != null) {
				String str[] = line.split(",");
				PremiumDetail premiumdetail = new PremiumDetail(str[0], str[1], str[2], Long.parseLong(str[3]), Long.parseLong(str[4]));
				set.add(premiumdetail);
			}
			}catch(ArrayIndexOutOfBoundsException r) {
				r.printStackTrace();
			}
			br.close();
			fr.close();
			return set;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PremiumDetail searchByName(String name, TreeSet<PremiumDetail> set) {
		PremiumDetail premium = new PremiumDetail();
		for (PremiumDetail pd : set) {
			if (name.equalsIgnoreCase(pd.getMemberName())) {
				premium = pd;
			}
		}
		return premium;
	}

}
