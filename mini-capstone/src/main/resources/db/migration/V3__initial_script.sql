DROP SCHEMA IF EXISTS richard cascade;
CREATE SCHEMA richard;

CREATE TABLE richard.todolist (
                               todo_id uuid,
                               todo varchar(300),
                               created_date TIMESTAMP WITH TIME ZONE,
                               modified_date TIMESTAMP WITH TIME ZONE,
                               PRIMARY KEY (todo_id)
);