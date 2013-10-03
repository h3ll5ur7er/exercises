import java.util.ArrayList;

/**
     * Project:
     * User: Emanuel Knecht
     * Date: 02.10.13
     */
    public class Debug
    {
        //instance gets created within first use (thread safe)
        private static Debug instance;

        // instance of log
        public Debug.Log logging = new Log();

        // lock file for thread-safety
        private static Object padlock = new Object();

        //get instance
        public static Debug Instance()
        {
            if (instance == null)
            {
                synchronized (padlock)
                {
                    if (instance == null)
                    {
                        instance = new Debug();
                    }
                }
            }
            return instance;
        }

        //get log
        public static Log Log()
        {
            return Instance().logging;
        }

        // private constructor
        private Debug()
        {

        }

        private static class Log
        {
            private static ArrayList<String> entries;

            private Log()
            {
                entries = new ArrayList<String>();
            }

            public static void Append(String message)
            {
                entries.add(message);
            }

            public static String ToString()
            {
                String temp = "";
                for (String entry : entries)
                    temp += entry+"\n";
                return temp;
            }
        }
    }
