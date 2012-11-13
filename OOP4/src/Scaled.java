public class Scaled<P extends Pict>  implements Pict {
	final private P[][] array;
	private static final int factor=1;
	
	public Scaled(P[][] array) {
		this.array=array;
	}

	@Override
	public void scale(double factor) {
		for (Pict[] row : array)
			for (Pict item : row)
				item.scale(factor);
	}
	
	
	@Override
	public String toString() {
		int[] maxHeights = new int[this.array.length]; // zeilen
		int[] maxWidths = new int[this.array[0].length]; // spalten

		int[][] heights = new int[this.array.length][this.array[0].length];
		int[][] widths = new int[this.array.length][this.array[0].length];

		for (int i = 0; i < maxHeights.length; i++) {
			for (int j = 0; j < maxWidths.length; j++) {
				String currentImage[] = array[i][j].toString().split(AbstractBox.NL);
				maxHeights[i] = Math.max(maxHeights[i], currentImage.length);
				heights[i][j] = currentImage.length;
				widths[i][j] = 0;
				for (int z = 0; z < currentImage.length; z++) {
					maxWidths[j] = Math.max(maxWidths[j],
							currentImage[z].length());
					widths[i][j] = Math.max(widths[i][j],
							currentImage[z].length());
				}

			}
		}
		
		int width = 0;
		int height = 0;
		for(int w : maxWidths) {
			width += w;
		}
		for(int h : maxHeights) {
			height += h;
		}

		StringBuilder builder = new StringBuilder();

		int resultHeight = (int) Math.ceil(height * factor);
		int resultWidth = (int) Math.ceil(width * factor);
		int currentLine = 0;
		for (int i = 0; i < maxHeights.length; i++) {
			String[][] imageLines = new String[maxWidths.length][maxHeights[i]];
			for (int j = 0; j < maxWidths.length; j++) {
				imageLines[j] = array[i][j].toString().split(AbstractBox.NL);
			}
			for (int z = 0; z < maxHeights[i]; z++) {
				currentLine++;
				StringBuilder line = new StringBuilder();
				for (int j = 0; j < maxWidths.length; j++) {
					if(heights[i][j] < maxHeights[i] && z >= heights[i][j]) {
						for(int s=0; s < maxWidths[j]; s++) {
							line.append(' ');
						}
					}else {
						while(imageLines[j][z].length() < maxWidths[j]) {
							imageLines[j][z] += ' ';
						}
						line.append(imageLines[j][z]);
					}
				}
				while(line.length() < resultWidth) {
					line.append(line);
				}
				line = new StringBuilder(line.substring(0, resultWidth));
				builder.append(line);
				builder.append(AbstractBox.NL);
				if(currentLine == resultHeight) {
					break;
				}
			}
			if(currentLine == resultHeight) {
				break;
			}
		}
		int numChars = resultWidth * resultHeight + AbstractBox.NL.length() * resultHeight;
		while(builder.length() < numChars) {
			builder.append(builder);
		}
		builder = new StringBuilder(builder.substring(0, numChars));

		return builder.substring(0, builder.length() - 1);

	
	}

}
