package task;

public class task {
    // Task Lists Table
    public static final String CREATE_TASK_LISTS_TABLE =
        "CREATE TABLE public.task_lists (" +
        "    list_id SERIAL PRIMARY KEY," +
        "    list_name VARCHAR(255) NOT NULL," +
        "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
        "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
        ");";

    // Tasks Table
    public static final String CREATE_TASKS_TABLE =
        "CREATE TABLE public.tasks (" +
        "    task_id SERIAL PRIMARY KEY," +
        "    list_id INTEGER REFERENCES public.task_lists(list_id) ON DELETE CASCADE," +
        "    task_name VARCHAR(255) NOT NULL," +
        "    due_date DATE," +
        "    priority VARCHAR(50) CHECK (priority IN ('Low', 'Medium', 'High'))," +
        "    status VARCHAR(50) DEFAULT 'Pending' CHECK (status IN ('Pending', 'Completed'))," +
        "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
        "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
        ");";

    // Users Table
    public static final String CREATE_USERS_TABLE =
        "CREATE TABLE public.users (" +
        "    user_id SERIAL PRIMARY KEY," +
        "    username VARCHAR(255) NOT NULL UNIQUE," +
        "    password_hash TEXT NOT NULL," +
        "    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
        "    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
        ");";

    // Index for faster username lookup
    public static final String CREATE_INDEX =
        "CREATE INDEX idx_username ON public.users USING btree (username);";
}
