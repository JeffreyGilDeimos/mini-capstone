DROP SCHEMA IF EXISTS john cascade;
CREATE SCHEMA john;

CREATE TABLE john.todolist (
                               todo_id uuid,
                               todo varchar(300),
                               created_date TIMESTAMP WITH TIME ZONE,
                               modified_date TIMESTAMP WITH TIME ZONE,
                               PRIMARY KEY (todo_id)
);