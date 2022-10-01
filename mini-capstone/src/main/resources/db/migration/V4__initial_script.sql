DROP SCHEMA IF EXISTS bong cascade;
CREATE SCHEMA bong;

CREATE TABLE bong.todolist (
                                  todo_id uuid,
                                  todo varchar(300),
                                  created_date TIMESTAMP WITH TIME ZONE,
                                  modified_date TIMESTAMP WITH TIME ZONE,
                                  PRIMARY KEY (todo_id)
);