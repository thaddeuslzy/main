package ssp.scheduleplanner.logic.parser;

import static ssp.scheduleplanner.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static ssp.scheduleplanner.logic.parser.CommandParserTestUtil.assertParseFailure;
import static ssp.scheduleplanner.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static ssp.scheduleplanner.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import org.junit.Test;

import ssp.scheduleplanner.logic.commands.DeleteCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new DeleteCommand(INDEX_FIRST_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteCommand.MESSAGE_USAGE));
    }
}
