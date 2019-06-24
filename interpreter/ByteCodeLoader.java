
package interpreter;

import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program p;
    private StringTokenizer st;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */

    public BopCode getOperator(String token) {
        return BopCode.getOperator(token);
    }

    public boolean hasLabel(String label) {
        return  label.equals("CallCode") ||
                label.equals("FalseBranchCode") ||
                label.equals("GotoCode") ||
                label.equals("LabelCode");
    }

    public Program loadCodes() {
        p = new Program();
        String s;

        try {
            while ((s = byteSource.readLine()) != null) {
                String token, byteCode;
                String[] tokenList = {"", ""};
                ByteCode bc;

                st = new StringTokenizer(s);
                token = st.nextToken();

                byteCode = CodeTable.getClassName(token);

                if (token.equals("BopCode")) {
                    token = st.nextToken();
                    bc = getOperator(token);
                    tokenList[0] = token;

                } else {
                    StringBuffer sb = new StringBuffer();
                    sb.append("interpreter.bytecode.");

                    if (hasLabel(token)) sb.append("jumpcode.");

                    sb.append(byteCode);
                    bc = (ByteCode) (Class.forName(sb.toString()).newInstance());

                    int i = 0;
                    while (st.hasMoreTokens()) {
                        token = st.nextToken();
                        tokenList[i] = token;
                        i++;
                    }
                }

                bc.init(tokenList[0],tokenList[1]);

                p.addByteCode(bc);
            }

            byteSource.close();
            p.resolveAddrs();

            return p;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return p;
    }
}
