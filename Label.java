public enum Label {
        VEGAN("vegan"),
        GLUTEN_FREE("gluten free"),
        /** If the labeled item conforms to "bio standards" */
        BIO("bio");

        /** The name of the label */
        String m_name;

        Label(String p_name) {
            m_name = p_name;
        }
}
