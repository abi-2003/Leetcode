typedef struct {
    int *keys;
    int *vals;
    int cap;
} hash;

hash *hash_init(int cap) {
    hash *ins = malloc(sizeof(hash));
    *ins = (hash){calloc(cap, sizeof(int)), calloc(cap, sizeof(int)), cap};
    return ins;
}

int hash_getIndex(hash *ins, int key) {
    int id = key % ins->cap;
    while (ins->keys[id] && ins->keys[id] != key) {
        if (++id == ins->cap)
            id = 0;
    }
    ins->keys[id] = key;
    return id;
}

void hash_free(hash *ins) {
    free(ins->keys);
    free(ins->vals);
    free(ins);
}

typedef struct {
    int *data;
    int cap;
    int len;
} vec;

vec *vec_init() {
    vec *ins = malloc(sizeof(vec));
    *ins = (vec){malloc(32 * sizeof(int)), 32, 0};
    return ins;
}

void vec_append(vec *ins, int num) {
    ins->data[ins->len] = num;
    if (++ins->len == ins->cap) {
        ins->cap *= 2;
        ins->data = realloc(ins->data, ins->cap * sizeof(int));
    }
}

void vec_free(vec *ins) {
    free(ins->data);
    free(ins);
}

int cmpAsc(const void *a, const void *b) { return *(int *)a - *(int *)b; }

long long Cn2(int n) { return (long long)n * (n - 1) / 2; }

long long countBadPairs(int *nums, int numsSize) {
    int cap = numsSize * 2;
    hash *tbl = hash_init(cap);
    for (int i = 0; i < numsSize; i++) {
        tbl->vals[hash_getIndex(tbl, nums[i] - i + numsSize)]++;
    }
    vec *freqs = vec_init();
    for (int i = 0; i < cap; i++) {
        if (tbl->vals[i] != 0)
            vec_append(freqs, tbl->vals[i]);
    }
    qsort(freqs->data, freqs->len, sizeof(int), cmpAsc);
    vec *freqVals = vec_init();
    vec *freqCnts = vec_init();
    for (int i = 0; i < freqs->len;) {
        int j = i;
        while (j < freqs->len && freqs->data[j] == freqs->data[i]) {
            j++;
        }
        vec_append(freqVals, freqs->data[i]);
        vec_append(freqCnts, j - i);
        i = j;
    }
    long long rs = 0;
    for (int i = 0; i < freqVals->len; i++) {
        rs += Cn2(freqCnts->data[i]) * freqVals->data[i] * freqVals->data[i];
        long long tmp = (long long)freqVals->data[i] * freqCnts->data[i];
        for (int j = i + 1; j < freqVals->len; j++) {
            rs += tmp * freqVals->data[j] * freqCnts->data[j];
        }
    }
    hash_free(tbl);
    vec_free(freqs);
    vec_free(freqVals);
    vec_free(freqCnts);
    return rs;
}
