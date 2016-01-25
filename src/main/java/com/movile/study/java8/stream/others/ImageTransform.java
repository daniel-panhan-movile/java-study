package com.movile.study.java8.stream.others;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.UnaryOperator;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageTransform extends Application {

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
		Image in = new Image(new FileInputStream(new File("src/main/resources/tree.png")));
		Image out = transform(in, Color::brighter);
		saveToFile(out, "src/main/resources/tree_brighter.png");
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Image transform(Image in, UnaryOperator<Color> f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y)));
		return out;
	}

	public static void saveToFile(Image image, String filename) {
		File outputFile = new File(filename);
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		try {
			ImageIO.write(bImage, "png", outputFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}