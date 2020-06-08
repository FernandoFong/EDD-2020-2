def swap(a, i, j):
    """
    Implementación clásica del swap, si son índices inválidos, este no modifica
    el arreglo.
    """
    if i > len(a) or j > len(a):
        return
    aux = a[i]
    a[i] = a[j]
    a[j] = aux

def merge_sort(array):
    """
    Implementación del algoritmo merge sort.
    Complejidad: O(n log n)
    """
    if len(array) <= 1: #Si es un elemento o ninguno, ya, terminé.
        return array # Lo regreso tal cual, ya está ordenado.
    h = len(array) // 2
    lft, rgt = array[0:h], array[h:] #División de los arreglos, izq y der.
    #Repito recursivamente aplicando la unión correcta, es decir, el merge.
    return merge(merge_sort(lft), merge_sort(rgt)) 

def merge(lft, rgt):
    """
    Unión en tiempo O(n) de dos arreglos ordenados.
    """
    array = [] #Creo un arreglo grandote.
    i,j = 0, 0 #Contadores para recorrer todos los elementos.
    while i < len(lft) and j < len(rgt):
    #Mientras que ambos tengan al menos un elemento.
        if(lft[i] <= rgt[j]): #Si l[i] <= r[j]
            array.append(lft[i])
            i += 1
        else: # Si r[j] > l[i]
            array.append(rgt[j])
            j += 1
    #Si j se quedó sin elementos, entonces esto se cumple e ignora el otro while
    while i < len(lft):
        array.append(lft[i])
        i += 1
    #Si i se quedó sin elementos, el while anterior fue ignorado.
    while j < len(rgt):
        array.append(rgt[j])
        j += 1
    #Regreso el arreglo con todos los elementos.
    return array

def quick_sort(array):
    if len(array) <= 1:
        return array
    left, right = [], []
    piv, times = array[0], 0
    for i in range(len(array)):
        if array[i] < piv:
            left.append(array[i])
        elif array[i] > piv:
            right.append(array[i])
        else:
            times += 1
    return quick_sort(left) + [piv]*times + quick_sort(right)

def bubble_sort(array):
    swapped = False
    #Hago una primer pasada para verificar que no estén ordenados ya
    #si no hago esto, entonces no hará nada.
    #Ventajas de tener do-while en un lenguaje.
    for i in range(len(array)-1):
        if(array[i] > array[i+1]): #Encontré uno fuera de lugar.
            swapped = True #Indico que sí hice un cambio.
            swap(array, i, i+1)
    while swapped: #Mientras que haya hecho un cambio.
        swapped = False #Supongo que ya no hay más cambios.
        for i in range(len(array)-1): 
            if(array[i] > array[i+1]):
                swapped = True #Hubo otro cambio.
                swap(array, i, i+1)

def selection_sort(array):
    for i in range(len(array)-1): #Para cada elemento menos el último.
        m = i
        for x in range(i+1, len(array)): #Recorro desde la íésima posición.
            if array[x] < array[m]: #Si veo uno menor.
                m = x #Recuerdo dónde estaba.
        swap(array, i, m) #Hago el swap.

def insertion_sort(array):
    last_sorted = 0
    for i in range(1, len(array)):
        j = last_sorted + 1
        while j > 0 and array[j] < array[j-1]:
            swap(array, j, j-1)
            j -= 1
        last_sorted += 1

if __name__ == '__main__':
    arr = [12, 4, 5, 3, 6, 6, 7, 10]
    #insertion_sort(arr)
    print(quick_sort(arr))
