NAME = ajav/Simulator
SRC_DIR = src
TARGET_DIR = target
RES_DIR = resources
INFILE ?= $(RES_DIR)/scenario.txt

SOURCES := $(shell find $(SRC_DIR) -name "*.java")

all: compile

compile:
	mkdir -p $(TARGET_DIR)
	javac -d $(TARGET_DIR) $(SOURCES)

run: compile
	java -cp $(TARGET_DIR) $(NAME) $(INFILE)

clean:
	rm -fr $(TARGET_DIR)

fclean: clean
	rm -fr $(TARGET_DIR)

re: fclean all

.PHONY: all compile run clean fclean re