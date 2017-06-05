#!/bin/sh

# Usage display message
function display_usage {
  echo "\nUsage:\n$0 <input_file_path> <properties_file_path> <output_file_path> \n"
  echo "\nFor example: sh replaceTokens.sh ../input/index.html ../conf/prod.properties ../output/index.html"
}
# Function to return the value of a property
function getPropertyValue {
   PROPERTY_FILE=$1
   PROP_KEY=$2
   PROP_VALUE=`cat $PROPERTY_FILE | grep "$PROP_KEY" | cut -d'=' -f2`
   echo $PROP_VALUE
}

# Check if all the input script arguments are provided
if [ $# -lt 3 ]; then
    display_usage
    exit 1
fi

echo "ReplaceTokens script starts...."

# Delete the output file if present
rm -f $3

# Read the contents of the input file into a variable
TMP_CONTENT=$(<$1)

# Loop through all the keys of the properties file
for KEY in `cat $2 | cut -d'=' -f1`; do
  # Call the function to get the property value for the key
  VAL=$(getPropertyValue "$2" "$KEY")

  # Replace the key placeholder in the variable containing the input file contents
  TMP_CONTENT=`echo "$TMP_CONTENT" | sed "s/\[\[$KEY\]\]/$VAL/g"`
done

# Flush the variable value to the output file
echo "$TMP_CONTENT" > $3

echo "ReplaceTokens script ends...."
exit 0
