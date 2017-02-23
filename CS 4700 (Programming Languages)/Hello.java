import java.io.FileReader;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;

public class CSV{
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(new FileReader(args[0]));
		// Construct a lexer
		//modify the input
		CSVLexer lexer = new CSVLexer(input);
		// Obtain the token stream from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Parse the token stream using the parser
		CSVParser parser = new CSVParser(tokens);
		// Start parsing, starting with the 'r' rule
		Trees.inspect(parser.r(), parser);
	}
}