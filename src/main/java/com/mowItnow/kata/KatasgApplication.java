package com.mowItnow.kata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import com.mowItnow.model.LawnClass;
import com.mowItnow.model.MowerClController;
import com.mowItnow.model.MowerClass;

@SpringBootApplication
public class KatasgApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(KatasgApplication.class, args);
		
        	// Use ClassPathResource to load the file
           
			ClassPathResource resource = new ClassPathResource("input.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))){
                // Read the lawn dimensions
                String[] lawnDimensions = br.readLine().split(" ");
                int maxX = Integer.parseInt(lawnDimensions[0]);
                int maxY = Integer.parseInt(lawnDimensions[1]);

                LawnClass lawn = new LawnClass(maxX, maxY);

                String line;
                while ((line = br.readLine()) != null) {
                    // Read the initial position and orientation of the mower
                    String[] initialPosition = line.split(" ");
                    int x = Integer.parseInt(initialPosition[0]);
                    int y = Integer.parseInt(initialPosition[1]);
                    char orientation = initialPosition[2].charAt(0);

                    MowerClass mower = new MowerClass(x, y, orientation);
                    MowerClController controller = new MowerClController(mower, lawn);

                    // Read the instructions for the mower
                    String instructions = br.readLine();
                    controller.executeInstructions(instructions);

                    // Print the final position and orientation of the mower
                    System.out.println(mower);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
	
	}

}


