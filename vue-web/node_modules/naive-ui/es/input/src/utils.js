export function len(s) {
    let count = 0;
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    for (const _ of s) {
        count++;
    }
    return count;
}
export function isEmptyValue(value) {
    return ['', undefined, null].includes(value);
}
