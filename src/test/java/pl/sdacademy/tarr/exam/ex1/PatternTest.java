package pl.sdacademy.tarr.exam.ex1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PatternTest {

	@Test
	@Parameters(method = "patternParameters")
	public void shouldCreateSquareAsFollows(char sign, int size, String pattern) throws Exception {
		// given
		Pattern sut = new Pattern();

		// when
		String actual = sut.prepareSquareWithDiagonals(sign, size);

		// then
		assertThat(actual).isEqualTo(pattern);

	}

	private Object patternParameters() {
		return new Object[][]{
				{'x', 0, ""},
				{'#', 1, "#\n"},
				{'*', 2, "* *\n* *\n"},
				{'@', 3, "@ @ @\n@ @ @\n@ @ @\n"},
				{'\u00A9', 4, "\u00A9 \u00A9 \u00A9 \u00A9\n\u00A9 \u00A9 \u00A9 \u00A9\n\u00A9 \u00A9 \u00A9 \u00A9\n\u00A9 \u00A9 \u00A9 \u00A9\n"},
				{'x', 5, "x x x x x\nx x   x x\nx   x   x\nx x   x x\nx x x x x\n"},
				{'%', 6, "% % % % % %\n% %     % %\n%   % %   %\n%   % %   %\n% %     % %\n% % % % % %\n"},
				{'#', 7, "# # # # # # #\n# #       # #\n#   #   #   #\n#     #     #\n#   #   #   #\n# #       # #\n# # # # # # #\n"}
		};
	}
}