# pramp problem
def flatten_dictionary(dictionary):
  output = {}
  fd_recurse(output, "", dictionary)
  clean_output(output)
  return output

def clean_output(output):
  for key in output:
    output[key[1:]] = output[key]
  deleted_key = []
  for key in output:
    if key[0] == '.':
      deleted_key.append(key)
  for key in deleted_key:
    del output[key]
      

def create_key(pk, k):
  if pk == "":
    return k
  else:
    return pk + '.' + k

def fd_recurse(output, parent_key, dictionary):
  for key in dictionary:
    if type(dictionary[key]) == str:
      new_key = create_key(parent_key, key)
      output[parent_key + '.' + key] = dictionary[key]
    else: # it's a dictionary
      fd_recurse(output, parent_key + '.' + key, dictionary[key])

# if type string
# write parent key + the string to the output
# if type dictionary
# pass down the key and recurse

dictionary = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : "1"
                }
            }
        }
print(flatten_dictionary(dictionary))
