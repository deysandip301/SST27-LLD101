package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipeLineFacade {
	public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
		Objects.requireNonNull(src, "src");
		Objects.requireNonNull(out, "out");
		Decoder dec = new Decoder();
		FilterEngine fe = new FilterEngine();
		Encoder enc = new Encoder();
		SharpenAdapter sharpen = new SharpenAdapter(new LegacySharpen());
		Frame[] frames = dec.decode(src);
		if (gray) {
			frames = fe.grayscale(frames);
		}
		if (scale != null) {
			frames = fe.scale(frames, scale);
		}
		if (sharpenStrength != null) {
			frames = sharpen.sharpen(frames, sharpenStrength);
		}
		return enc.encode(frames, out);
	}
}
